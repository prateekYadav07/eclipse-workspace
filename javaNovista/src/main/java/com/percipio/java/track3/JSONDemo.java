package com.percipio.java.track3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

public class JSONDemo {

	//reading a json object consisting arrays as a value to a file
	public static void main(String[] args) {
		try (FileReader file = new FileReader("diners-list.json")){
			JSONObject diners = (JSONObject) JSONValue.parse(file);
			for(Object array : (JSONArray) diners.get("diners")) {
				JSONObject diner = (JSONObject) array;
				System.out.println(diner);
				
				diner.entrySet().stream().forEach(System.out::println);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//writing a json object consisting arrays as a value to a file
	/*
	 * @SuppressWarnings("unchecked") public static void main(String[] args) {
	 * JSONObject dinerObject = new JSONObject();
	 * 
	 * JSONArray list = new JSONArray();
	 * 
	 * JSONObject diner1 = new JSONObject(); diner1.put("name", "Jane Stark");
	 * diner1.put("age", 22); diner1.put("gender", "Female");
	 * diner1.put("isAllergic", false); diner1.put("amountSpent", 153.27);
	 * 
	 * JSONObject diner2 = new JSONObject(); diner2.put("name", "Jon Snow");
	 * diner2.put("age", 25); diner2.put("amountSpent", 750.5);
	 * 
	 * list.add(diner1); list.add(diner2);
	 * 
	 * dinerObject.put("diners", list); System.out.println(dinerObject); try
	 * (FileWriter file = new FileWriter("diners-list.json")) {
	 * dinerObject.writeJSONString(file); } catch (IOException e) {
	 * e.printStackTrace(); } }
	 */

	// reading from a file to a jsonArray
	/*
	 * public static void main(String[] args) { try (FileReader file = new
	 * FileReader("diner.json")){ JSONArray jsonArray = (JSONArray)
	 * JSONValue.parse(file); System.out.println(jsonArray);
	 * jsonArray.listIterator().forEachRemaining(item -> System.out.println(item));
	 * } catch (IOException e) { e.printStackTrace(); } }
	 */

	// reading from a file to a json object
	/*
	 * public static void main(String[] args) { try(FileReader file = new
	 * FileReader("diner.json")) { JSONObject diner = (JSONObject)
	 * JSONValue.parse(file); System.out.println(diner);
	 * System.out.println(diner.get("isAllergic")); } catch (IOException e) { //
	 * TODO: handle exception } }
	 */

	// writing a json to a file
	/*
	 * @SuppressWarnings("unchecked") public static void main(String[] args) {
	 * 
	 * JSONObject diner = new JSONObject(); diner.put("name", "Jane Stark");
	 * diner.put("age", 22); diner.put("gender", null); diner.put("isAllergic",
	 * false); diner.put("amountSpent", 153.27);
	 * 
	 * System.out.println(diner.toJSONString()); try (FileWriter file = new
	 * FileWriter("diner.json")) { diner.writeJSONString(file); } catch (IOException
	 * e) { e.printStackTrace(); }
	 * 
	 * }
	 */

}
