import { createActions, handleActions } from "redux-actions";

const initialState = [];

export const POST_SIGNUP = 'member/POST_SIGNUP';
export const GET_DUPLICATION = 'member/POST_DUPLICATION';
export const POST_SIGNIN = 'member/POST_SIGNIN';
export const POST_TOKENCHECK = 'member/POST_TOKENCHECK';

const actions = createActions({
    [POST_SIGNUP]: () => {},
    [GET_DUPLICATION]: () => {},
    [POST_SIGNIN]: () => {},
    [POST_TOKENCHECK]: () => {},
})

export const memberReducer = handleActions(
    {
        [POST_SIGNUP]: (state, { payload }) => {
            return payload;
        },
        [GET_DUPLICATION]: (state, { payload }) => {
            return payload;
        },
        [POST_SIGNIN]: (state, { payload }) => {
            return payload;
        },
        [POST_TOKENCHECK]: (state, { payload }) => {
            return payload;
        },
    },
    initialState
);