import mongoose from "mongoose";
import bcrypt from "bcrypt";

const UsuarioSchema = new mongoose.Schema({
  nome: { type: String, required: true },
  email: { type: String, required: true, unique: true },
  senha: { type: String, required: true },
  posts: [{ type: Schema.Types.ObjectId, ref: 'Post' }]
});

// Hash a senha antes de salvar
UsuarioSchema.pre('save', async function (next) {
  if (!this.isModified('password')) {
      return next();
  }
  const salt = await bcrypt.genSalt(10);
  this.password = await bcrypt.hash(this.password, salt);
  next();
});

// Método para comparar senhas
UsuarioSchema.methods.comparePassword = function (candidatePassword) {
  return bcrypt.compare(candidatePassword, this.password);
};

const Usuario = mongoose.models.Usuario || mongoose.model('Usuario', UsuarioSchema);
 
export default Usuario;
