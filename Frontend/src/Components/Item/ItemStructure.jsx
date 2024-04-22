import React from "react";
import PropTypes from "prop-types";
import { useNavigate } from "react-router";
import axios from "axios";

function ItemStructure(props) {
  const navigate = useNavigate();

  const handleAddToBasket = () => {
    axios
      .patch(`http://localhost:8088/item/add/${props.id}/1`)
      .then(() => {
        navigate("/items");
      })
      .catch((error) => alert('Item has already been added to the basket '));
  };

  const deleteItem = () => {
    axios
      .delete(`http://localhost:8088/item/delete/${props.id}`)
      .then(() => {
      })
      .catch((error) => alert('Item has already been deleted '));
  };

  return (
    <div id="itemCard" className="card-group d-inline-flex padding" style={{padding: "20px"}}>
      <div class="card border-dark mb-3" style={{width: "17%"}}>
        <ul class="list-group list-group-flush">
          <li class="list-group-item">Name: {props.name} </li>
          <li class="list-group-item">Price: £{props.price} </li>
        </ul>
      <button type="button" onClick={handleAddToBasket} className="btn btn-success ">
        Add to basket
      </button>
      <button type="button" onClick={deleteItem} className="btn btn-danger">Delete</button>
      </div>
    </div>
  );
}

ItemStructure.propTypes = {
  name: PropTypes.string.isRequired,
  quantity: PropTypes.number.isRequired,
  price: PropTypes.number.isRequired,
  id: PropTypes.number.isRequired,
};

export default ItemStructure;
