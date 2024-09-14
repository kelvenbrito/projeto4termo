import Usuario from "@/model/Usuario";
import connectMongo from "@/utils/dbConnect";

import { NextResponse } from "next/server";

export async function POST(request) {
    const data = await request.json();
    await connectMongo();

    try {
       const usuario = await Usuario.create(data);
      
        return NextResponse.json({succes: true, data:usuario});
        
    } catch (error) {
        return NextResponse.json({succes: false}, {status:400});
    }
  

}
