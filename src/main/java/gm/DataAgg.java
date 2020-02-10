package gm;






import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * JSON can represent two structured types: objects and arrays.
 * An object is an unordered collection of zero or more name/value pairs. An array is an ordered sequence of zero or more values.
 * The values can be strings, numbers, booleans, null, and these two structured types.
 */


class Request {

    List<Pets> petsList;

}

class Pets {
      String Breed;
      boolean IsFixed;
    String Name;
    String Source;
    String  Type;
    Pets(){}
    public String getBreed() {
        return Breed;
    }

    public void setBreed(String breed) {
        Breed = breed;
    }

    public boolean isFixed() {
        return IsFixed;
    }

    public void setFixed(boolean fixed) {
        IsFixed = fixed;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}



public class DataAgg {

    public static void main(final String[] argv)  {
        //Request car = objectMapper.readValue(json, Request.class);
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