import React from "react";
import PropTypes from "prop-types";
import ItemStructure from "./ItemStructure";

function ItemDisplay({ listItems }) {
  return (
    <div>
      {listItems.map((item) => (
        <ItemStructure
          key={item.id}
          id={item.id}
          name={item.name}
          price={item.price}
        />
      ))}
    </div>
  );
}

ItemDisplay.propTypes = {
  listItems: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.number.isRequired,
      name: PropTypes.string.isRequired,
      price: PropTypes.number.isRequired,
    })
  ).isRequired,
};

export default ItemDisplay;
