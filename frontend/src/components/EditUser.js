import React, {Component, useEffect, useState} from 'react';
import {Table, Button, Form} from 'react-bootstrap';
import axios from "axios";
import {useParams, useHistory} from "react-router-dom";



function EditUser() {

    axios.defaults.headers.common['Authorization'] = localStorage.getItem("token");
    const history = useHistory();

    const {id} = useParams();

    const [user, setUser] = useState({});

    const sendUser=(e) =>{
        e.preventDefault();

        console.log(user)

        axios.put('/createUser/'+id, user)
            .catch((err) => {
                console.log(err);
            });
        history.push("/users");
    }

    useEffect(() => {
        console.log(id)
        axios.get("/getUser/"+id)
            .then((res) => {
                setUser(res.data);
            })
            .catch((err) => {
                console.log(err);
            });
    }, []);
    return (

        <div>
            <h1>Edit User</h1>
            <Form>
                <Form.Group className="mb-3" controlId="formBasicEmail">
                    <Form.Label>Username</Form.Label>
                    <Form.Control onChange={(e)=>setUser({username: e.target.value, password: user.password})}  type="email" value={user.username}/>

                </Form.Group>

                <Form.Group className="mb-3" controlId="formBasicPassword">
                    <Form.Label>Password</Form.Label>
                    <Form.Control onChange={(e)=>setUser({username: user.username, password: e.target.value})}  type="password" value={user.password}/>
                </Form.Group>
                <Button onClick={(e)=>sendUser(e)} variant="primary" type="submit">
                    Change
                </Button>
            </Form>
        </div>
    )
};


export default EditUser;