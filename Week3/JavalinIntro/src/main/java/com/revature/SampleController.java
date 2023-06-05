package com.revature;

import io.javalin.http.Context;

public class SampleController {

    public static void handleGet(Context ctx){
        ctx.result("Hello World from the sample Controller");
    }
}
