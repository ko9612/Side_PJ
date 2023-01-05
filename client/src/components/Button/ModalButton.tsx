import { WideB } from "./SubmitButton";

interface ModalButProps {
  children: string;
  onClick: React.MouseEventHandler<HTMLButtonElement>;
}

export default function ModalButton({ children, onClick }: ModalButProps) {
  return (
    <WideB
      className={`py-3 focus:ring-0 rounded-none ${
        ((children === "아니오" || children === "취소") &&
          "bg-slate-200 hover:bg-slate-300 focus:bg-slate-300 text-black") ||
        ((children === "삭제" || children === "탈퇴") &&
          " bg-red-500 hover:bg-red-600 focus:bg-red-600")
      }`}
      onClick={onClick}
    >
      {children}
    </WideB>
  );
}
