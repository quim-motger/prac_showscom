package edu.upc.as.domain.serviceinterface;

import edu.upc.as.exception.ServeiNoDisponible;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by jmotger on 12/01/16.
 */
public class SvCurrencyConvertor {

    public float conversionRate(String divisa, String moneda) throws ServeiNoDisponible{
        try {
            InputStream input = new URL("http://api.fixer.io/latest?base=" + divisa + "&symbols=" + moneda).openStream();
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(input, "UTF-8"));

            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);

            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(responseStrBuilder.toString());

            String rates = json.get("rates").toString();

            json = (JSONObject) parser.parse(rates);
            float imp = Float.parseFloat(json.get(moneda).toString());

            return imp;
        }
        catch (Exception e) {
            throw new ServeiNoDisponible();
        }
    }

}
