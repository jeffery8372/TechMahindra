import React from "react";

interface CartItemProps {
  name: string;
  price: number;
  quantity: number;
  onRemove: () => void;
}

const CartItem: React.FC<CartItemProps> = ({
  name,
  price,
  quantity,
  onRemove,
}) => {
  return (
    <div className="card p-3 m-2">
      <h5>{name}</h5>
      <p>Price: ₹{price}</p>
      <p>Quantity: {quantity}</p>
      <button className="btn btn-danger" onClick={onRemove}>
        Remove
      </button>
    </div>
  );
};

export default CartItem;
