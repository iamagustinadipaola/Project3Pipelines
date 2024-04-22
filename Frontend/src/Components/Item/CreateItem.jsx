import { useState } from "react";
import { useNavigate } from "react-router-dom"
import axios from "axios";

function CreateItem() {
    const [name, setName] = useState("");
    const [price, setPrice] = useState();
    const navigate = useNavigate("");


    return (
        <div className="card-group d-inline-flex padding">
            <form onSubmit={e => {
                e.preventDefault()
                axios.post("http://localhost:8088/item/create", { name, price })
                    .then(response => {
                        setName("");
                        setPrice();
                        navigate("/items");
                    })
                    .catch(err => console.error(err))
            }}>
                <div className="container" id="CreateItem">
                    <div className="row">
                        <div className="col">
                            <div label htmlfor="name" className="form-label ">Name</div>
                            <input type="text" id="name" size="20" value={name} onChange={e => setName(e.target.value)} required />
                        </div>
                        <div className="col">
                            <div label htmlfor="price" className="form-label ">Price</div>
                            <input type="number" id="price" size="5" step="0.01" value={price} onChange={e => setPrice(e.target.value)} required />
                        </div>
                    </div>
                </div>
                <br />
                <div>
                    <button type="submit" id="SubmitCreateItem" className="btn btn-success"> Submit </button>
                </div>

            </form>
        </div>

    );
}

export default CreateItem;