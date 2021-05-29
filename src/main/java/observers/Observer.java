package observers;

import java.util.List;

import model.Center;

public interface Observer
{
    public void update(List<Center> availableCenterList);
}