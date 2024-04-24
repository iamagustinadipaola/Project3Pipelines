import React, { useState, useEffect } from "react";
import axios from "axios";

function BasketsDisplay() {
  const [baskets, setBaskets] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8088/basket/get")
      .then(response => setBaskets(response.data))
      .catch(error => console.error(error));
  }, []);

  const calculateTotalPrice = (items) => {
    if (!items || items.length === 0) {
      return 0;
    }

    return items.reduce((total, item) => total + item.price, 0);
  };

  return (
    <div>
      <div className="card-group d-inline-flex padding" style={{ padding: "10px" }}>
        <div class="card border-dark mb-3" style={{ width: "17%", textAlign: "center" }}>
          <div class="card-body"></div>
          {baskets.map(basket => (
            <div key={basket.id}>
              <h3>{basket.name}</h3>
              <div>
                {basket.items.map(basketItem => (
                  <div key={basketItem.id}>
                    {basketItem.name} - Price: £{basketItem.price} 
                  </div>
                ))}
                <br/>
              </div>
              <p>Total Price: £{calculateTotalPrice(basket.items)}</p>
            </div>
          ))}
        </div>
      </div>
    </div>

  );
}

export default BasketsDisplay;
