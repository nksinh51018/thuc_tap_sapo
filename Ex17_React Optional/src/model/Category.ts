import Product from "./Product";

export default interface Category {
  id: number;
  categoryCode: string;
  categoryName: string;
  categoryDescription: string;
  createAt: Date;
  updatedAt: Date;
  productDTOs: Product[];
}
