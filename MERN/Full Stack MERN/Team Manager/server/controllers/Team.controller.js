const { Team } = require('../models/Team.model');

module.exports.createTeam = (request, response) => {
    const { name,position,role } = request.body;
    Team.create({
        name,
        position,
        role
    })
        .then(team =>response.json(team))
        .catch(err =>response.status(400).json(err))
}

module.exports.getAllTeams = (request, response) => {
    Team.find({})
        .then(teams => response.json(teams))
        .catch(err => response.json(err))
}

module.exports.getTeam = (request, response) => {
    Team.findOne({_id:request.params.id})
        .then(team => response.json(team))
        .catch(err => response.json(err))
}
module.exports.deleteAnExistingTeam = (req, res) => {
    Team.deleteOne({ _id: req.params.id })
      .then(result => res.json({ result: result }))
      .catch(err => res.json({ message: "Something went wrong", error: err }));
  };

  module.exports.updateTeam = (request, response) => {
    Team.findOneAndUpdate({_id: request.params.id}, request.body, {new:true})
        .then(updatedTeam => response.json(updatedTeam))
        .catch(err => response.json(err))

}