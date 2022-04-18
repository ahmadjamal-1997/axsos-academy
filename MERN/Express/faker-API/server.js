
const express = require("express");
const app = express();
const port = 8000;
const { faker } = require('@faker-js/faker');
const User = require('./components/User')
const Company = require('./components/Company')


// make sure these lines are above any app.get or app.post code blocks
app.use( express.json() );
app.use( express.urlencoded({ extended: true }) );

const createUser = ()=>{
    const newUser = new User(
        faker.datatype.number(),
        faker.internet.email(),
        faker.datatype.number(),
        faker.name.firstName(),
        faker.name.lastName()
    )
    return newUser;

}
const createCompany = ()=>{
    const newCompany = new Company(
        faker.name.findName(),
        {
            street : faker.address.streetAddress(),
            city : faker.address.city(),
            state : faker.address.state(),
            zipCode :faker.address.zipCode(),
            country : faker.address.country(),
            
        }
        
    )
    
        return newCompany;
}
// app.get("/api/users/new" , (req,res)=>{
//     res.json(User);
// })
// app.get("/api/companies/new" , (req,res)=>{
//     res.json(Company);
// })
app.get("/api/user/company" , (req,res)=>{
    const newUser = createUser();
    const newCompany = createCompany();
    res.json({newUser,newCompany});
    // res.json(newCompany);
})
app.get("/api/users", (req, res) => {
    // req.body will contain the form data from Postman or from React
    console.log(req.body);
    // we can push it into the users array for now. // later on this will be inserted into a database
    const newUser = createUser();
    // we always need to respond with something
    res.json(newUser);
    });
app.get("/api/company", (req, res) => {
    // req.body will contain the form data from Postman or from React
    // console.log(req.body);
    
    // we can push it into the users array for now. // later on this will be inserted into a database
    const newCompany = createCompany();
    // we always need to respond with something
    res.json(newCompany);
    });

// this needs to below the other code blocks
app.listen( port, () => console.log(`Listening on port: ${port}`) );