import tw from "tailwind-styled-components";
import { BsChevronLeft, BsChevronRight } from "react-icons/bs";
import BlogItem from "../BlogItem";

export const Section = tw.section`
lg:w-[64rem] mx-auto mb-20
`;

export const Title = tw.p`
text-2xl py-2 max-w-[56rem] mx-auto
`;

export const BestContent = tw.article`
flex items-center
`;

export const BestItem = tw.div`
w-[56rem] mx-auto
`;

const CarouselPaging = tw.div`
flex justify-center py-6
`;

export default function BestBlog() {
  return (
    <Section>
      <Title>금주의 인기 블로그</Title>
      <BestContent>
        <BsChevronLeft className="text-MainColor" size="3rem" role="button" />
        <BestItem>
          <BlogItem />
        </BestItem>
        <BsChevronRight className="text-MainColor" size="3rem" role="button" />
      </BestContent>
      <CarouselPaging>
        <span className="px-2">1</span>/<span className="px-2">5</span>
      </CarouselPaging>
    </Section>
  );
}
