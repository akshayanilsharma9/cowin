import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class CheckCowin extends TimerTask{
    @Override
    public void run() {
        try {
            checkSlots();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkSlots() throws IOException {
        return true;
    }

    public static void main(String args[]) throws IOException {
        /*URL url = new URL("https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByDistrict?district_id=257&date=19-05-2021");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36");
        conn.connect();
        int responsecode = conn.getResponseCode();
conn.getResponseMessage();
        String inline = "";
        Scanner scanner = new Scanner(url.openStream());

        //Write all the JSON data into a string using a scanner
        while (scanner.hasNext()) {
            inline += scanner.nextLine();
        }*/
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByDistrict?district_id=257&date=28-05-2021")
                .method("GET", null)
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36")
                .build();
        Response responses = client.newCall(request).execute();
        List<SlotDetail> slotDetailList = new ArrayList<>();
        int totalSlots = 0;
        SlotDetail slotDetail = new SlotDetail();
        Session session = new Session();
        Map<String, Session> sessionMap = new HashMap<>();
        List<Map<String, Session>> slotDetailsMapList = new ArrayList<>();
        List<Session> sessionList = new ArrayList<>();
        Map<String,SlotDetail> slotDetailMap = new HashMap<>();
        Map<SlotDetail, List<Session>> slotDetailListMap = new HashMap<>();
        try {
            JSONObject jsonObject = new JSONObject(responses.body().string());
            JSONArray jsonArray = jsonObject.getJSONArray("centers");
            for (int i = 0; i< jsonArray.length();i++) {
                JSONObject slotdetails = jsonArray.getJSONObject(i);
                JSONArray sessionArray = slotdetails.getJSONArray("sessions");
                for (int j = 0; j < sessionArray.length(); j++) {
                    JSONObject sessions = sessionArray.getJSONObject(j);
                    ObjectMapper objectMapper = new ObjectMapper();
                    session = objectMapper.readValue(sessions.toString(), Session.class);
                    totalSlots += session.getAvailableCapacityDose1();
                    if (session.getAvailableCapacityDose1() > 0) {
                        slotDetail = objectMapper.readValue(slotdetails.toString(), SlotDetail.class);
                        sessionList.add(session);
                    }
                }
                slotDetailListMap.put(slotDetail, sessionList);
                System.out.println("Center added");
            }
            // Do something here
        } catch (JSONException | IOException e) {
            System.out.println(e.toString());
        }
       /* Map<SlotDetail, Set<Session>> slotDetailSessionMap = new HashMap<>();
        Set<Session> filteredSlotDetailsList = new HashSet<>();
        for (SlotDetail slot:slotDetailList) {
            for (Session s : slot.getSessions()) {
                if (s.getAvailableCapacityDose1() > 0) {
                    filteredSlotDetailsList.add(s);
                }
                slotDetailSessionMap.put(slot, filteredSlotDetailsList);
            }
        }
*/
        //slotDetailList.forEach(System.out::println);
        System.out.println(slotDetailList.get(0));
    }
}





