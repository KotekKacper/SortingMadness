package pl.put.poznan.sorter.rest;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JSON implements Comparable<JSON> {
    public JsonNode node;
    public String key;

    public JSON(JsonNode _node, String _key)
    {
        node = _node;
        key = _key;
    }

    @Override
    public int compareTo(JSON compered){
        if(node.get(key).isNumber() && compered.node.get(compered.key).isNumber())
            return Double.valueOf(node.get(key).asDouble()).compareTo(compered.node.get(compered.key).asDouble());
        return node.get(key).toString().compareTo(compered.node.get(compered.key).toString());
    }

    @Override
    public String toString() {
        return node.toString();
    }
}
