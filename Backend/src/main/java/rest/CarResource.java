package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dtos.CarDTO;
import facades.CarFacade;
import facades.FacadeExample;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;

@Path("cars")
public class CarResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final CarFacade FACADE =  CarFacade.getCarFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces("application/json")
    public String getAllCars() {
        return GSON.toJson(FACADE.getAllCars());
    }
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public String addCar(String car) {
        String brand;
        String model;
        String numberPlate;
        try{
            JsonObject json = JsonParser.parseString(car).getAsJsonObject();
            brand = json.get("brand").getAsString();
            model = json.get("model").getAsString();
            numberPlate = json.get("numberPlate").getAsString();
        } catch (Exception e) {
            return "{\"error\":\"Invalid JSON\"}";
        }
        CarDTO carDTO = new CarDTO(brand, model, numberPlate);
        return GSON.toJson(FACADE.create(carDTO));
    }
    @DELETE
    @Path("{id}")
    public void deleteCar(@PathParam("id") int id) {
        Long idLong = Long.valueOf(id);
        FACADE.deleteCar(idLong);
    }

}
