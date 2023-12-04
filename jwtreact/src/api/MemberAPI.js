import {
    POST_REFRESHTOKEN,
    POST_SIGNIN,
    POST_SIGNUP, POST_TOKENCHECK
} from "../modules/MemberModule";
import { useNavigate } from "react-router-dom";
import {getCookie, removeCookie, setCookie} from "../Cookie";
import {decodeJwt} from "../TokenUtil";

export const callPostSignupAPI = (data) => {

    const requestURL = `http://localhost:8888/member/signup`;

    return async (dispatch, getState) => {

        const result = await fetch(requestURL, {
            method : "POST",
            body : data
        })
            .then(response => response.json())
        if(result.status === 201) {
            dispatch({type: POST_SIGNUP, payload : result});
        }
    }
}

export const callGettDuplicationAPI = (data) => {
    const requestURL = `http://localhost:8888/member/duplication/${data}`;

    return async (dispatch, getState) => {

        const result = await fetch(requestURL, {
            method : "GET",
        })
            .then(response => response.json())
        if(result.status === 200) {
            dispatch({type: POST_SIGNUP, payload : result});
        }
    }
}

export const callPostSigninAPI = (data) => {

    console.log(data);
    const requestURL = "http://localhost:8888/member/login";
    const expiration = new Date(Date.now() + 1000 * 60 * 60 * 24 * 15)

    return async (dispatch, getState) => {

        const result = await fetch(requestURL, {
            method : "POST",
            body : data
        })
            .then(response => response.json())
        if(result.status === 200) {
            dispatch({type: POST_SIGNIN, payload : result});
            setCookie("accessToken", result.data.accessToken, {path : "/", sameSite : "strict", expires : expiration})
            setCookie("refreshToken", result.data.refreshToken, {path : "/", sameSite : "strict", expires : expiration})
            const accessToken = getCookie("accessToken");
            const decodedToken = accessToken? decodeJwt(accessToken) : null;
            localStorage.setItem("userInfo", JSON.stringify(decodedToken));
            alert('로그인에 성공하셨습니다.');
            window.location="/";
        } else {
            alert("아이디 또는 비밀번호가 맞지 않습니다.");
            window.location="/login";
        }
    }
}

export const callPostTokenCheckAPI = (data) => {

    const requestURL = "http://localhost:8888/member/tokenCheck";
    const expiration = new Date(Date.now() + 1000 * 60 * 60 * 24 * 15)

    return async (dispatch, getState) => {

        const result = await fetch(requestURL, {
            method: "POST",
            body: data
        })
            .then(response => response.json())
        if (result.status === 200) {
            dispatch({type: POST_TOKENCHECK, payload: result});
            if(result.data == false) {
                removeCookie("accessToken");
                removeCookie("refreshToken");
                window.location = "/login"
            } else if(result.data == true) {
                window.location="/detail";
            } else {
                setCookie("accessToken", result.data, {path : "/", sameSite : "strict", expires : expiration})
                window.location="/detail";
            }
        }
    }
}