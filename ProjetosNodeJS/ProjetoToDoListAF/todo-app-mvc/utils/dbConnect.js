import mongoose from "mongoose";

const DATABASE_URL = process.env.DATABASE_URL;

const connectMongo = async() => {
    moongose.connect(DATABASE_URL)
    .then(()=>connsole.log("conectado com MongoDB"))
    .catch(err=>console.error(err));
}

export default connectMongo;