import { Product } from "./product";

export class Cart {
    product:Product;
    quantity:number;
    totalAmount:string;
    constructor(product,quantity,totalAmount){
        this.product=product;
        this.quantity=quantity;
        this.totalAmount=totalAmount;

    }
}
