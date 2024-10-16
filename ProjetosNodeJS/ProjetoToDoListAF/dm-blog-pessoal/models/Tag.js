const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const TagSchema = new Schema({
  nome: { type: String, required: true }
});

module.exports = mongoose.model('Tag', TagSchema);
