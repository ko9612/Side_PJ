import { BsEnvelopeFill } from "react-icons/bs";
import { useState } from "react";
import SubmitButton from "../../Button/SubmitButton";
// import LoginInput from "../Input/LoginInput";
import DefalutButton from "../../Button/DefalutButton";
import { Input, LoginInput } from "./SigninForm";

export default function SignupForm() {
  const [emailBut, setEmailBut] = useState(false);
  return (
    <form className="mb-10">
      {/* 닉네임 */}
      <Input>
        <LoginInput type="text" id="name" placeholder="닉네임" maxLength={6} />
      </Input>

      {/* 이메일 */}
      <Input>
        <div className="flex">
          <div className="flex-1">
            <LoginInput
              type="email"
              id="email"
              placeholder="이메일"
              maxLength={25}
            />
          </div>
          <div className="ml-2">
            <DefalutButton onClick={() => setEmailBut(true)}>
              <BsEnvelopeFill size="25px" />
            </DefalutButton>
          </div>
        </div>
      </Input>

      {/* 이메일 인증 입력 */}
      {emailBut && (
        <Input>
          <div className="flex">
            <div className="flex-1">
              <LoginInput
                type="text"
                id="emailCertification"
                placeholder="인증번호 입력"
                maxLength={10}
              />
            </div>
            {/* 인증번호 완료버튼 */}
            <div className="ml-2">
              <DefalutButton onClick={() => {}}>확인</DefalutButton>
            </div>
          </div>
        </Input>
      )}
      {/* 비밀번호 */}
      <div className="mb-10">
        <Input>
          <LoginInput
            type="password"
            id="password"
            placeholder="비밀번호"
            maxLength={15}
          />
        </Input>
        <Input>
          <LoginInput
            type="password"
            id="passwordConfrim"
            placeholder="비밀번호 확인"
            maxLength={15}
          />
        </Input>
      </div>
      <SubmitButton onClick={() => {}}>회원가입</SubmitButton>
    </form>
  );
}
