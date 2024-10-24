import logo from './logo.svg';
import styled from 'styled-components';
import './App.css';
import { Title, DescriptText } from './components/CommonsStyles';
import SearchBar from './components/SearchBar';
import { useEffect, useState } from 'react';
import { CallGpt, CallGptAxios } from './service/gptAPI';
import ChatDisplay from './components/ChatDisplay';

function App() {
  const [searchText, setSearchText] = useState("");
  const [isLoading, setIsLoading] = useState(false);
  const [chatDataList, setChatDataList] = useState(localStorage.getItem("chatList") ? 
                                                    JSON.parse(localStorage.getItem("chatList")) : []);

  const changeSearchText = (ev) => {
    setSearchText(ev.target.value)
  }

  const clickSearchIcon = async () => {
    if(searchText.trim() === "")
      return;

    const chatData = {
      date: new Date().getTime(),
      question: searchText
    }

    try{
      setIsLoading(true);
      setSearchText("");
      const message = await CallGptAxios({
        prompt: chatData.question
      })

      chatData.message = message;

      setChatDataList([
        ...chatDataList,
        chatData
      ])
    } catch(error){
      console.log(error)
    } finally {
      setIsLoading(false);
    }

  }

  //chatDataList의 값이 변경되면 localStorage에 저장해줘
  useEffect(() => {
    localStorage.setItem("chatList", JSON.stringify(chatDataList))
  }, [chatDataList])

  return (
    <AppContainer className="App">
      <Header>
        <Title>나만의 GPT</Title>
      </Header>
      <Contents>
        <ChatDisplay 
          chatDataList = {chatDataList}
          isLoading = {isLoading}
        />
      </Contents>
      <Footer>
        <SearchBar 
          searchText = {searchText}
          changeSearchText = {changeSearchText}
          clickSearchIcon = {clickSearchIcon}
        />
        <DescriptText>
          ChatGPT는 실수를 할 수 있습니다. 중요한 정보를 확인하세요.
        </DescriptText>
      </Footer>
    </AppContainer>
  );
}

export default App;

const AppContainer = styled.div`
    display: flex;
    flex-direction: column;
    height: 100vh;
    width: 100%;
    max-width: 720px;
    margin: 0 auto;
`
const Header = styled.div`
    padding: 8px;
    height: 56px;
    width: 100%;
    background: white;
`

const Contents = styled.div`
    padding: 60px 0 0 0;
    flex: 1;
    overflow-y: scroll;
    &::-webkit-scrollbar{
      display: none;
    }
`

const Footer = styled.div`
    height: 86px;
    display: flex;
    flex-direction: column;
`