import React, { Component } from 'react';
import {PostData} from './PostData';
import './bootstrap/css/bootstrap.min.css';
import './dist/css/AdminLTE.min.css';
import './plugins/iCheck/square/blue.css';
class LoginForm extends Component {
    constructor(props){
        super(props);
        this.state = ({
           username: '',
           password: ''
        });
        this.login = this.login.bind(this);
        this.onChange = this.onChange.bind(this);
    }
    login(){
        if(this.state.username && this.state.password){
            PostData('login',this.state)
                .then((result) => {
                    let responseJSON = result;
                    console.log(result);
                    // if(responseJSON.username){
                    //     sessionStorage.setItem('userData',responseJSON.userId);
                    //     this.setState({redirect:true})
                    // }else{
                    //     console.log("login error");
                    // }
                });
        }
    }
    onChange(e){
        this.setState({
            [e.target.name]: e.target.value
        });
    }
    render() {
        return (
            <div>
                <div className="login-box">
                    <div className="login-logo">
                        <b>Welcome to</b>TODO app
                    </div>
                    <div className="login-box-body">
                        <form action="" method="post">
                            <div className="form-group has-feedback">
                                <input type="text" className="form-control" name="username" placeholder="username" required onChange={this.onChange}/>
                            </div>
                            <div className="form-group has-feedback">
                                <input type="password" className="form-control" name="password" placeholder="Password" required onChange={this.onChange}/>
                                <span className="glyphicon glyphicon-lock form-control-feedback"></span>
                            </div>
                            <div className="row">
                                <div className="col-xs-4">
                                    <button type="button" className="btn btn-primary btn-block btn-flat" onClick={this.login}>
                                        Sign In
                                    </button>
                                </div>
                            </div>
                        </form>

                        <a href="/register" className="text-center center-block">
                            Register a new membership
                        </a>

                    </div>
                </div>
            </div>
        );
    }
}

export default LoginForm;
