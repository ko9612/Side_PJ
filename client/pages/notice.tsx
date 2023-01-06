import tw from "tailwind-styled-components";
import NavBar from "../src/components/Nav/NavBar";
import { Main } from "./index";
import NoticeList from "../src/components/List/NoticeList";
import Footer from "../src/components/Footer/Footer";

export const Title = tw.div`
w-[52rem] m-auto mt-20 mb-10
`;

export const Content = tw.div`
border-2 border-green-500 w-[52rem] m-auto mt-20
`;

export const HR = tw.div`
p-0.5 bg-gray-200
`;

export default function Notice() {
  return (
    <>
      <NavBar />
      <Main>
        <Title>
          <h1 className="text-3xl font-bold">알림</h1>
        </Title>
        <HR />
        <Content>
          <NoticeList />
        </Content>
      </Main>
      <Footer />
    </>
  );
}
