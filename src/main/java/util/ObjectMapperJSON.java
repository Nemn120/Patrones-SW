package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import factorymethod.icecream.IceCreams;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ObjectMapperJSON {
    ObjectMapper objectMapper = new ObjectMapper();

    public <T> T readObject(String path,Class<T> object) throws IOException {
        return objectMapper.readValue(new File(path),object);
    }

    public void writeObject(String path,Object object) throws IOException {
        objectMapper.writeValue(new File(path),object);
    }

    /*public <T> T writeExistsObject(String path,T object, Class<T> ObjectClass) throws IOException {
        IceCreams iceCreams = (List<Object>) objectMapper.readValue(new File(path),ObjectClass);
        if(objectList == null){
            objectList = new ArrayList<>();
        }
        objectList.add(object);
        objectMapper.writeValue(new File(path),objectList);
        return object;
    }
    */





}
