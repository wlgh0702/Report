import * as React from 'react';
import Link from '@mui/material/Link';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Title from './Title';
import {getCookie} from "./Cookie";
import {decodeJwt} from "./TokenUtil";
import {useDispatch} from "react-redux";
import {callPostTokenCheckAPI} from "./api/MemberAPI";

// Generate Order Data
function createData(id, date, name, shipTo, paymentMethod, amount) {
    return { id, date, name, shipTo, paymentMethod, amount };
}

const rows = [
    createData(
        0,
        '16 Mar, 2019',
        'Elvis Presley',
        'Tupelo, MS',
        'VISA ⠀•••• 3719',
        312.44,
    ),
    createData(
        1,
        '16 Mar, 2019',
        'Paul McCartney',
        'London, UK',
        'VISA ⠀•••• 2574',
        866.99,
    ),
    createData(2, '16 Mar, 2019', 'Tom Scholz', 'Boston, MA', 'MC ⠀•••• 1253', 100.81),
    createData(
        3,
        '16 Mar, 2019',
        'Michael Jackson',
        'Gary, IN',
        'AMEX ⠀•••• 2000',
        654.39,
    ),
    createData(
        4,
        '15 Mar, 2019',
        'Bruce Springsteen',
        'Long Branch, NJ',
        'VISA ⠀•••• 5919',
        212.79,
    ),
];

function preventDefault(event) {
    event.preventDefault();
}

export default function Orders() {

    const dispatch = useDispatch();
    const accessToken = getCookie("accessToken");
    const decodedToken = accessToken? decodeJwt(accessToken) : null;
    const onClickHandler = () => {
        dispatch(callPostTokenCheckAPI(accessToken));
    }
    return (
        <React.Fragment>
            <Title>Recent Orders</Title>
            <Table size="small">
                <TableHead>
                    <TableRow>
                        <TableCell>Date</TableCell>
                        <TableCell>Name</TableCell>
                        <TableCell>Ship To</TableCell>
                        <TableCell>Payment Method</TableCell>
                        <TableCell align="right">Sale Amount</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {rows.map((row) => (
                        <TableRow key={row.id}>
                            <TableCell>{row.date}</TableCell>
                            <TableCell>{row.name}</TableCell>
                            <TableCell>{row.shipTo}</TableCell>
                            <TableCell>{row.paymentMethod}</TableCell>
                            <TableCell align="right">{`$${row.amount}`}</TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
            <div style={{cursor : "pointer", color : "blue"}} onClick={onClickHandler} sx={{ mt: 3 }}>
                See more orders
            </div>
        </React.Fragment>
    );
}