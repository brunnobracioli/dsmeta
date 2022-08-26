
import axios from "axios";
import { useEffect, useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { Venda } from "../../models/venda";
import { BASE_URL } from "../../utils/request";


import NotificationButton from '../notificationButton'
import './styles.css'

function SalesCard() {

    const min = new Date(new Date().setDate(new Date().getDate() - 365));
    const max = new Date();

    const [minDate, setMinDate] = useState(min);
    const [maxDate, setMaxDate] = useState(max);

    const [venda, setVenda] = useState<Venda[]>([])

    useEffect(() => {

        const dataMin = minDate.toISOString().slice(0, 10)
        const dataMax = maxDate.toISOString().slice(0, 10)


        axios.get(`${BASE_URL}/vendas?minData=${dataMin}&maxData=${dataMax}`)
            .then(response => {
                setVenda(response.data.content)
            })

    }, [minDate, maxDate])


    return (
        <><div className="dsmeta-card">
            <h2 className="dsmeta-sales-title">Vendas</h2>
            <div>
                <div className="dsmeta-form-control-container">
                    <DatePicker
                        selected={minDate}
                        onChange={(date: Date) => setMinDate(date)}
                        className="dsmeta-form-control"
                        dateFormat="dd/MM/yyyy"
                    />
                </div>
                <div className="dsmeta-form-control-container">
                    <DatePicker
                        selected={maxDate}
                        onChange={(date: Date) => setMaxDate(date)}
                        className="dsmeta-form-control"
                        dateFormat="dd/MM/yyyy"
                    />

                </div>
            </div>
        </div><div>
                <table className="dsmeta-sales-table">
                    <thead>
                        <tr>
                            <th className="show992">ID</th>
                            <th className="show576">Data</th>
                            <th>Vendedor</th>
                            <th className="show992">Visitas</th>
                            <th className="show992">Vendas</th>
                            <th>Total</th>
                            <th>Notificar</th>
                        </tr>
                    </thead>
                    <tbody>
                        {venda.map(venda => {
                            return (
                                <tr key ={venda.id}>
                                    <td className="show992">{venda.id}</td>
                                    <td className="show576">{new Date(venda.data).toLocaleDateString()}</td>
                                    <td>{venda.nomeVendedor}</td>
                                    <td className="show992">{venda.visita}</td>
                                    <td className="show992">{venda.venda}</td>
                                    <td>R$ {venda.quantiaVendida.toFixed(2)}</td>
                                    <td>
                                        <div className="dsmeta-red-btn-container">
                                            <NotificationButton />
                                        </div>
                                    </td>
                                </tr>
                            )
                        })}

                    </tbody>
                </table>
            </div></>

    )
}

export default SalesCard