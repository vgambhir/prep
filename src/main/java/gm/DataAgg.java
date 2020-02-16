package gm;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * JSON can represent two structured types: objects and arrays.
 * An object is an unordered collection of zero or more name/value pairs. An array is an ordered sequence of zero or more values.
 * The values can be strings, numbers, booleans, null, and these two structured types.
 * Use Jackson Object Mapper
 * https://mkyong.com/java8/java-8-collectors-groupingby-and-mapping-example/
 */


class Request {

    @JsonProperty("Pets")
    List<Pets> petsList;

    @Override
    public String toString() {
        return "Request{" +
                "petsList=" + petsList +
                '}';
    }

}

class Pets {
   @JsonProperty("Breed")
    String breed;
    @JsonProperty("IsFixed")
    Boolean isFixed;
    @JsonProperty("Name")
    String name;
    @JsonProperty("Source")
    String source;
    @JsonProperty("Type")
    String type;

    Pets() {
    }

    public Boolean getIsFixed() {
        return isFixed;
    }

    public void setIsFixed(Boolean isFixed) {
        this.isFixed = isFixed;
    }
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "breed='" + breed + '\'' +
                ", isFixed=" + isFixed +
                ", name='" + name + '\'' +
                ", source='" + source + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}


public class DataAgg {

    public static void main(final String[] argv) throws IOException {
        //
        ObjectMapper objectMapper = new ObjectMapper();
        Request req = objectMapper.readValue(new File("petsGM.json"), Request.class);
        System.out.println(req);
        System.out.println("****************");
        System.out.println(objectMapper.writeValueAsString(req));

        List<Pets> petsList = req.petsList;
        Map<String, Long> counting = petsList.stream().collect(Collectors.groupingBy(Pets::getType, Collectors.counting()));
        System.out.println(counting);
        Map<String, Long> countByBreed = petsList.stream().collect(Collectors.groupingBy(Pets::getBreed, Collectors.counting()));
        System.out.println(countByBreed);

    }
}
/*
{
  "Pets":[
    {
      "Breed":"Dingo",
      "IsFixed":false,
      "Name":"Fido",
      "Source":"Australia Kennel Network",
      "Type":"Dog"
    },
    {
      "Breed":"Siamese",
      "IsFixed":true,
      "Name":"Fluffy",
      "Source":"Lost and Found",
      "Type":"Cat"
    }
  ]
}
 */