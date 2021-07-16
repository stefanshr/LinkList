import {useEffect, useState} from "react";
import axios from "axios";
import {Table, Button, Form} from 'react-bootstrap';
import {Link} from "react-router-dom";


const UserList = (props) => {

    axios.defaults.headers.common['Authorization'] = localStorage.getItem("token");

    const [users, setUsers] = useState([]);

    const getUsers = async () => {
        const result = await axios.get('/api/getUsers')
        setUsers(result.data)
    }

    const deleteUser = (id) => {
        axios.delete("/api/deleteUser/" + id)
            .catch((err) => {
                console.log(err);
            });
        getUsers();
        window.location.reload();
    }


    useEffect(() => {
        getUsers()
    }, [])

    const userList = users.map(user => {
        return <Table striped bordered hover>
            <thead>
            <tr>
                <th>#</th>
                <th>Username</th>
                <th>Password</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>{user.id}</td>
                <td>{user.username}</td>
                <td>{user.password}</td>
                <td>
                    <Link to={"/EditUser/"+user.id} className="btn btn-warning">Update</Link>
                </td>
                <td>
                    <Button  variant="danger" onClick={() => deleteUser(user.id)}>Delete</Button>
                </td>
            </tr>
            </tbody>
        </Table>
    });
    return (
        <div>
            {userList}
            <div className="float-right">
                <Link to={"/addUser"} className="btn btn-primary  btn-lg btn-block">Add User</Link>
            </div>
            <br/>
            <div className="float-right">
                <Link  to={"/athletes"} className="btn btn-info  btn-lg btn-block">Go Athletes</Link>
            </div>
        </div>
    );


}

export default UserList;