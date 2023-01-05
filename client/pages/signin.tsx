import tw from "tailwind-styled-components";
import SignGuide from "../src/components/Sign/SignGuide";
import SignRightContent from "../src/components/Sign/SignRightContent";
import Logo from "../src/components/Sign/SignLogo";
import SocialLogin from "../src/components/Sign/SocialForm";
import SigninForm from "../src/components/Sign/SigninForm";

export const Main = tw.main`
flex items-center justify-center h-screen bg-slate-200
`;

export const Content = tw.section`
flex w-[64rem] rounded-md bg-white shadow-sm
`;

export const LeftContent = tw.article`
w-full mt-40 mb-5
`;

export const InputDiv = tw.div`
mt-8 px-16
`;

export default function SignIn() {
  return (
    <Main>
      <Content>
        <SignRightContent />
        <LeftContent>
          <Logo />
          <InputDiv>
            <SigninForm />
            <SocialLogin />
            <SignGuide
              msg="아직 회원이 아니신가요?"
              sign="회원가입"
              href="/signup"
            />
          </InputDiv>
        </LeftContent>
      </Content>
    </Main>
  );
}