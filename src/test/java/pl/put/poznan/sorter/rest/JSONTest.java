package pl.put.poznan.sorter.rest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class JSONTest {

    void setupObject(JsonNode field, JsonNode parent, String key, boolean isNumber, Double number, String string)
    {
        when(parent.get(key)).thenReturn(field);
        when(field.getNodeType()).thenReturn(isNumber ? JsonNodeType.NUMBER : JsonNodeType.STRING);
        when(field.asDouble()).thenReturn(number);
        when(field.toString()).thenReturn(string);
    }

    @Test
    void CompareNumbersDifferent()
    {
        JsonNode AObject = mock(JsonNode.class);
        JsonNode AField = mock(JsonNode.class);
        setupObject(AField, AObject, "a", true, 2.0, "2.0");

        JsonNode BObject = mock(JsonNode.class);
        JsonNode BField = mock(JsonNode.class);
        setupObject(BField, BObject, "b", true, 11.0, "11.0");

        JSON TestedA = new JSON(AObject, "a");
        JSON TestedB = new JSON(BObject, "b");

        assertEquals(true, TestedA.compareTo(TestedB) < 0);
        assertEquals(false, TestedB.compareTo(TestedA) < 0);
        assertEquals(false, TestedA.compareTo(TestedB) > 0);
        assertEquals(true, TestedB.compareTo(TestedA) > 0);

        verify(AObject, atLeastOnce()).get("a");
        verify(AObject, never()).get(AdditionalMatchers.not(eq("a")));

        verify(BObject, atLeastOnce()).get("b");
        verify(BObject, never()).get(AdditionalMatchers.not(eq("b")));

        verify(AField, atLeastOnce()).isNumber();
        verify(BField, atLeastOnce()).isNumber();

        verify(AField, atLeastOnce()).asDouble();
        verify(BField, atLeastOnce()).asDouble();
    }

    @Test
    void CompareNumbersEqual()
    {
        JsonNode AObject = mock(JsonNode.class);
        JsonNode AField = mock(JsonNode.class);
        setupObject(AField, AObject, "a", true, 1.0, "1.0");

        JsonNode BObject = mock(JsonNode.class);
        JsonNode BField = mock(JsonNode.class);
        setupObject(BField, BObject, "b", true, 1.0, "1.0");

        JSON TestedA = new JSON(AObject, "a");
        JSON TestedB = new JSON(BObject, "b");

        assertEquals(true, TestedA.compareTo(TestedB) == 0);
        assertEquals(false, TestedB.compareTo(TestedA) != 0);

        verify(AObject, atLeastOnce()).get("a");
        verify(AObject, never()).get(AdditionalMatchers.not(eq("a")));

        verify(BObject, atLeastOnce()).get("b");
        verify(BObject, never()).get(AdditionalMatchers.not(eq("b")));

        verify(AField, atLeastOnce()).isNumber();
        verify(BField, atLeastOnce()).isNumber();

        verify(AField, atLeastOnce()).asDouble();
        verify(BField, atLeastOnce()).asDouble();
    }

    @Test
    void CompareStringsDifferent_1()
    {
        JsonNode AObject = mock(JsonNode.class);
        JsonNode AField = mock(JsonNode.class);
        setupObject(AField, AObject, "a", false, 0.0, "a");

        JsonNode BObject = mock(JsonNode.class);
        JsonNode BField = mock(JsonNode.class);
        setupObject(BField, BObject, "b", false, 0.0, "b");

        JSON TestedA = new JSON(AObject, "a");
        JSON TestedB = new JSON(BObject, "b");

        assertEquals(true, TestedA.compareTo(TestedB) < 0);
        assertEquals(false, TestedB.compareTo(TestedA) < 0);
        assertEquals(false, TestedA.compareTo(TestedB) > 0);
        assertEquals(true, TestedB.compareTo(TestedA) > 0);

        verify(AObject, atLeastOnce()).get("a");
        verify(AObject, never()).get(AdditionalMatchers.not(eq("a")));

        verify(BObject, atLeastOnce()).get("b");
        verify(BObject, never()).get(AdditionalMatchers.not(eq("b")));

        verify(AField, atLeastOnce()).isNumber();
        verify(BField, atLeastOnce()).isNumber();

        verify(AField, never()).asDouble();
        verify(BField, never()).asDouble();
    }

    @Test
    void CompareStringsDifferent_2()
    {
        JsonNode AObject = mock(JsonNode.class);
        JsonNode AField = mock(JsonNode.class);
        setupObject(AField, AObject, "a", false, 0.0, "a");

        JsonNode BObject = mock(JsonNode.class);
        JsonNode BField = mock(JsonNode.class);
        setupObject(BField, BObject, "b", false, 0.0, "aa");

        JSON TestedA = new JSON(AObject, "a");
        JSON TestedB = new JSON(BObject, "b");

        assertEquals(true, TestedA.compareTo(TestedB) < 0);
        assertEquals(false, TestedB.compareTo(TestedA) < 0);
        assertEquals(false, TestedA.compareTo(TestedB) > 0);
        assertEquals(true, TestedB.compareTo(TestedA) > 0);

        verify(AObject, atLeastOnce()).get("a");
        verify(AObject, never()).get(AdditionalMatchers.not(eq("a")));

        verify(BObject, atLeastOnce()).get("b");
        verify(BObject, never()).get(AdditionalMatchers.not(eq("b")));

        verify(AField, atLeastOnce()).isNumber();
        verify(BField, atLeastOnce()).isNumber();

        verify(AField, never()).asDouble();
        verify(BField, never()).asDouble();
    }

    @Test
    void CompareStringsEqual()
    {
        JsonNode AObject = mock(JsonNode.class);
        JsonNode AField = mock(JsonNode.class);
        setupObject(AField, AObject, "a", false, 0.0, "a");

        JsonNode BObject = mock(JsonNode.class);
        JsonNode BField = mock(JsonNode.class);
        setupObject(BField, BObject, "b", false, 0.0, "a");

        JSON TestedA = new JSON(AObject, "a");
        JSON TestedB = new JSON(BObject, "b");

        assertEquals(true, TestedA.compareTo(TestedB) == 0);
        assertEquals(false, TestedB.compareTo(TestedA) != 0);

        verify(AObject, atLeastOnce()).get("a");
        verify(AObject, never()).get(AdditionalMatchers.not(eq("a")));

        verify(BObject, atLeastOnce()).get("b");
        verify(BObject, never()).get(AdditionalMatchers.not(eq("b")));

        verify(AField, atLeastOnce()).isNumber();
        verify(BField, atLeastOnce()).isNumber();

        verify(AField, never()).asDouble();
        verify(BField, never()).asDouble();
    }

    @Test
    void CompareStringsNumbersDifferent()
    {
        JsonNode AObject = mock(JsonNode.class);
        JsonNode AField = mock(JsonNode.class);
        setupObject(AField, AObject, "a", true, 1.0, "1.0");

        JsonNode BObject = mock(JsonNode.class);
        JsonNode BField = mock(JsonNode.class);
        setupObject(BField, BObject, "b", false, 0.0, "b");

        JSON TestedA = new JSON(AObject, "a");
        JSON TestedB = new JSON(BObject, "b");

        assertEquals(true, TestedA.compareTo(TestedB) < 0);
        assertEquals(false, TestedB.compareTo(TestedA) < 0);
        assertEquals(false, TestedA.compareTo(TestedB) > 0);
        assertEquals(true, TestedB.compareTo(TestedA) > 0);

        verify(AObject, atLeastOnce()).get("a");
        verify(AObject, never()).get(AdditionalMatchers.not(eq("a")));

        verify(BObject, atLeastOnce()).get("b");
        verify(BObject, never()).get(AdditionalMatchers.not(eq("b")));

        verify(AField, atLeastOnce()).isNumber();
        verify(BField, atLeastOnce()).isNumber();

        verify(AField, never()).asDouble();
        verify(BField, never()).asDouble();
    }

    @Test
    void CompareStringsNumbersEqual()
    {
        JsonNode AObject = mock(JsonNode.class);
        JsonNode AField = mock(JsonNode.class);
        setupObject(AField, AObject, "a", true, 1.0, "1.0");

        JsonNode BObject = mock(JsonNode.class);
        JsonNode BField = mock(JsonNode.class);
        setupObject(BField, BObject, "b", false, 1.0, "1.0");

        JSON TestedA = new JSON(AObject, "a");
        JSON TestedB = new JSON(BObject, "b");

        assertEquals(true, TestedA.compareTo(TestedB) == 0);
        assertEquals(false, TestedB.compareTo(TestedA) != 0);

        verify(AObject, atLeastOnce()).get("a");
        verify(AObject, never()).get(AdditionalMatchers.not(eq("a")));

        verify(BObject, atLeastOnce()).get("b");
        verify(BObject, never()).get(AdditionalMatchers.not(eq("b")));

        verify(AField, atLeastOnce()).isNumber();
        verify(BField, atLeastOnce()).isNumber();

        verify(AField, never()).asDouble();
        verify(BField, never()).asDouble();
    }

}
