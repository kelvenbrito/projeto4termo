import Todo from "@/models/Todo";
import connectMongo from "@/utils/dbConnect";

//Criar o CRUD

// READ
export const getTodos = async () => {
    connectMongo;
    try {
        return await Todo.find();
    } catch (error) {
        console.error(error);
    }
};

//CREATE
export const createTodo = async (data) => {
    connectMongo;
    try {
        return await Todo.create(data);

    } catch (error) {
        console.error(error);
    }

};

//UPDATE
export const updateTodo = async (id, data) => {
    connectMongo();
    try {
        return await Todo.findByIdAndUpdate(id, data, {
            new: true,
            runValidators: true,
        });
    }
    catch (error) {
        console.error(error);
    }
}

//DELETE
export const deleteTodo = async (id) => {

    connectMongo();
    try {
        return await Todo.deleteOne({ _id: id });
    }
    catch (error) {
        console.error(error);
    }
};

