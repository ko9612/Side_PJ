import tw from "tailwind-styled-components";
import { DefaultProps } from "./DefalutButton";

const WideB = tw.button`
w-full px-4 py-2 text-white duration-100 bg-MainColor rounded-lg hover:bg-SubColor
 focus:bg-SubColor focus:ring focus:ring-MainColor/40 h-[4rem] text-xl font-semibold
`;

export default function WideButton({ children, onClick }: DefaultProps) {
  return (
    <WideB type="submit" onClick={onClick}>
      {children}
    </WideB>
  );
}
