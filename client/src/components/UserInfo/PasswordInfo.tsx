import {
  InfoSection,
  InfoTitle,
  InfoContent,
  EditList,
  Input,
  InputLabel,
} from "./InfoStyle";
import DefaultInput from "../Input/DefaultInput";
import DefalutButton from "../Button/DefalutButton";

export default function PasswordInfo() {
  return (
    <InfoSection>
      <div className="flex justify-between items-center">
        <InfoTitle>비밀번호 설정</InfoTitle>
        <p className="text-sm text-gray-500">
          ※ 비밀번호는 8~15자의 영문 대/소문자, 숫자, 특수문자를 혼합해서
          사용하실 수 있습니다.
        </p>
      </div>
      <InfoContent>
        <EditList>
          <InputLabel htmlFor="curPassword">현재 비밀번호</InputLabel>
          <Input>
            <DefaultInput type="password" id="curPassword" />
          </Input>
        </EditList>
        <EditList>
          <InputLabel htmlFor="newPassword">새 비밀번호 </InputLabel>
          <Input>
            <DefaultInput type="password" id="newPassword" />
          </Input>
        </EditList>
        <EditList>
          <InputLabel htmlFor="ConfirmPassword">새 비밀번호 확인</InputLabel>
          <Input>
            <DefaultInput type="password" id="ConfirmPassword" />
          </Input>
        </EditList>
        <div className="flex justify-end">
          <DefalutButton onClick={() => {}}>비밀번호 변경</DefalutButton>
        </div>
      </InfoContent>
    </InfoSection>
  );
}
