const TeamController = require('../controllers/Team.controller');
module.exports = function(app){
    app.post('/api/team', TeamController.createTeam);
    app.get('/api/team', TeamController.getAllTeams);
    app.get('/api/team/:id', TeamController.getTeam);
    app.delete('/api/team/:id',TeamController.deleteAnExistingTeam);
    app.put('/api/team/:id', TeamController.updateTeam);
}