import tw from "tailwind-styled-components";
import AccountInfo from "../../UserInfo/AccountInfo";
import PasswordInfo from "../../UserInfo/PasswordInfo";
import AddressInfo from "../../UserInfo/AddressInfo";
import RefundInfo from "../../UserInfo/RefundInfo";
import SubmitButton from "../../Button/SubmitButton";

const InfoContent = tw.main`
justify-center items-center mx-auto
`;

export default function MyInfoList() {
  return (
    <InfoContent>
      <AccountInfo />
      <PasswordInfo />
      <AddressInfo />
      <RefundInfo />
      <div className="pt-20">
        <SubmitButton onClick={() => {}}>내 정보 저장하기</SubmitButton>
      </div>
    </InfoContent>
  );
}
