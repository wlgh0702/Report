import * as React from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import {useEffect, useState} from 'react';
import {callGettDuplicationAPI, callPostSignupAPI} from "./api/MemberAPI";
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate } from "react-router-dom";

function Copyright(props) {
    return (
        <Typography variant="body2" color="text.secondary" align="center" {...props}>
            {'Copyright © '}
            <Link color="inherit" href="https://mui.com/">
                Your Website
            </Link>{' '}
            {new Date().getFullYear()}
            {'.'}
        </Typography>
    );
}


// TODO remove, this demo shouldn't need to reset the theme.

const defaultTheme = createTheme();

export default function SignUp() {

    const dispatch = useDispatch();
    const navigate = useNavigate();
    const result = useSelector(state => state.memberReducer);
    const [id, setId] = useState('');

    const onChangeHandler = (e) => {
        setId(e.target.value);
    }

    const onBlurHandler = () => {
        dispatch(callGettDuplicationAPI(id));
    }

    const handleSubmit = (event) => {

        event.preventDefault();
        const data = new FormData(event.currentTarget);

        if(result.data === 0) {
            dispatch(callPostSignupAPI(data));
            alert("회원가입에 성공하셨습니다.");
            navigate('/', {replace : true});
        } else {

            alert('중복된 아이디입니다. 다시 입력해주세요.');
        }
    };

    return (
        <ThemeProvider theme={defaultTheme}>
            <Container component="main" maxWidth="xs">
                <CssBaseline />
                <Box
                    sx={{
                        marginTop: 8,
                        display: 'flex',
                        flexDirection: 'column',
                        alignItems: 'center',
                    }}
                >
                    <Avatar sx={{ m: 1, bgcolor: 'secondary.main' }}>
                        <LockOutlinedIcon />
                    </Avatar>
                    <Typography component="h1" variant="h5">
                        Sign up
                    </Typography>
                    <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
                        <Grid container spacing={2}>
                            {/*<Grid item xs={12}>*/}
                            {/*    <TextField*/}
                            {/*        autoComplete="given-name"*/}
                            {/*        name="firstName"*/}
                            {/*        required*/}
                            {/*        fullWidth*/}
                            {/*        id="firstName"*/}
                            {/*        label="First Name"*/}
                            {/*        autoFocus*/}
                            {/*    />*/}
                            {/*</Grid>*/}
                            <Grid item xs={12}>
                                <TextField
                                    onChange={e => onChangeHandler(e)}
                                    onBlur={onBlurHandler}
                                    required
                                    fullWidth
                                    id="memberId"
                                    label="ID"
                                    name="memberId"
                                    autoComplete="family-name"
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <TextField
                                    required
                                    fullWidth
                                    id="password"
                                    label="Password"
                                    type="password"
                                    name="memberPwd"
                                    autoComplete="email"
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <TextField
                                    required
                                    fullWidth
                                    name="memberName"
                                    label="Name"
                                    id="name"
                                    autoComplete="new-password"
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <FormControlLabel
                                    control={<Checkbox value="allowExtraEmails" color="primary" />}
                                    label="I agree to sign up"
                                />
                            </Grid>
                        </Grid>
                        <Button
                            type="submit"
                            fullWidth
                            variant="contained"
                            sx={{ mt: 3, mb: 2 }}
                        >
                            Sign Up
                        </Button>
                        {/*<Grid container justifyContent="flex-end">*/}
                        {/*    <Grid item>*/}
                        {/*        <Link href="#" variant="body2">*/}
                        {/*            Already have an account? Sign in*/}
                        {/*        </Link>*/}
                        {/*    </Grid>*/}
                        {/*</Grid>*/}
                    </Box>
                </Box>
                <Copyright sx={{ mt: 5 }} />
            </Container>
        </ThemeProvider>
    );
}