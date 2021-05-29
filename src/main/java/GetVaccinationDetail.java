import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import model.Center;
import model.Session;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

@Slf4j
public class GetVaccinationDetail extends TimerTask {

    @Override
    public void run() {
        try {
            getVaccinationSlots();
        } catch (IOException e) {
            log.error("Error in getting  Vaccination Data");
            e.printStackTrace();
        }
    }

    public List<Center> getVaccinationSlots() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String currentDate = formatter.format(date);
        String url = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByDistrict?district_id=257&date=" + currentDate;
        Request request = new Request.Builder().url(url).method("GET", null).addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36").build();
        log.info("Making call to CoWin Api to get Vaccination Data");
        Response responses = client.newCall(request).execute();
        List<Center> centerList = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(responses.body().string());
            JSONArray centersJsonArray = jsonObject.getJSONArray("centers");
            for (int i = 0; i < centersJsonArray.length(); i++) {
                ObjectMapper objectMapper = new ObjectMapper();
                Center center = objectMapper.readValue(centersJsonArray.get(i).toString(), Center.class);
                centerList.add(center);
            }
        } catch (JSONException jsonException) {
            log.error("Error reading CoWin JSON Data");
        }

        List<Center> filteredCenterList = new ArrayList<>(centerList.size());
        for (Center center : centerList) {
            List<Session> filteredSessionList = new ArrayList<>(centerList.size());
            for (Session session : center.getSessions()) {
                if (session.getAvailableCapacityDose1() > 0 || session.getAvailableCapacityDose2() > 0) {
                    log.info("Filtering sessions based on vaccine availability");
                    filteredSessionList.add(session);
                }
            }
            center.setSessions(filteredSessionList);
            if (filteredSessionList.size() > 0) {
                filteredCenterList.add(center);
            }
            log.info("Added Centers having vaccines");
        }
        log.info("Sharing List of Centers having vaccines...");
        return filteredCenterList;
    }
}
