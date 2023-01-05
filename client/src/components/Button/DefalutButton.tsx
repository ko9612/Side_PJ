import tw from "tailwind-styled-components";

export interface DefaultProps {
  children: string | JSX.Element;
  onClick: React.MouseEventHandler<HTMLButtonElement>;
}

export default function DefalutButton({ children, onClick }: DefaultProps) {
  const DButton = tw.button`
    p-2 px-5 bg-MainColor rounded-lg text-white duration-100 hover:bg-SubColor 
    focus:bg-SubColor focus:ring focus:ring-MainColor/40 whitespace-nowrap
    `;

  return <DButton onClick={onClick}>{children}</DButton>;
}
