import mongoose from "mongoose";


const TodoSchema = new mongoose.Schema({
    title:{
        tipe:Script,
        required:true
    },
    description:{
        tipe:String
    },
    completed:{
        type:Enum('A Fazer', 'Fazendo', 'Concuido'),
        default:'A Fazer'
    }
});

const Todo = moongoose.models.Todo || mongoose.model('Todo', TodoSchema);

export default Todo;