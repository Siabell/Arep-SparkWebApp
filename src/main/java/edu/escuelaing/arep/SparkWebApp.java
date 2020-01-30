package edu.escuelaing.arep;
import static spark.Spark.*;
import com.google.gson.Gson;

import edu.escuelaing.arep.calculator.CalculatorApp;
public class SparkWebApp {

	private static CalculatorApp calculator;
	public static void main(final String[] args) {
		port(getPort());
		staticFiles.location("/WebCalculator");
		final Gson gson = new Gson();
		
        get("/calculator/:data", (request, response) -> {
			//response.redirect("/index.html");
			response.type("application/json");
            final String calculatorResult = CalculatorApp.calculator(request.params(":data"));
            System.out.println(calculatorResult);
            response.status(200);
            return gson.toJson(calculatorResult);
		});

	}
	

	


	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
			}
			return 4567; 
			 //returns default port if heroku-port isn't set (i.e. on localhost)
	}
}