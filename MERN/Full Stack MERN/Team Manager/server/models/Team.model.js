const mongoose = require('mongoose');
const TeamSchema = new mongoose.Schema({
    name: { 
        type: String,
        required: [
            true,
            "Name is required"
        ] },
    position : {type :String},
    role : {type:String}
    
}, { timestamps: true });
module.exports.Team = mongoose.model('Team', TeamSchema);