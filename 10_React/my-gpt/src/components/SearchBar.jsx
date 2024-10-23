import React, { useState } from 'react'
import styled from 'styled-components';
import { FaArrowUp } from "react-icons/fa";

const SearchBar = ({searchText, changeSearchText, clickSearchIcon}) => {

    return (
        <SearchBarContainer>
            <SearchInput
                value={searchText}
                onChange={changeSearchText}
                type="text"
                placeholder='궁금한 것을 물어보세요....'
            />
            <UploadIconBox
                search = {searchText}
                onClick={clickSearchIcon}
                >
                <FaArrowUp
                    style={{
                        color: "white"
                    }}
                />
            </UploadIconBox>
        </SearchBarContainer>
    )
}

export default SearchBar

const SearchBarContainer = styled.div`
    width: 100%;
    border: 1px solid #f5f5f5;
    background: #f5f5f5;
    border-radius: 25px;
    height: 52px;
    position: relative;
    padding: 14px 50px 14px 14px;
    margin: 0 0 6px 0;
`

const SearchInput = styled.input`
    border: none;
    outline: none;
    background: none;
    width: 100%;
    height: 100%;
`

const UploadIconBox = styled.div`
    position: absolute;
    top: 7px;
    right: 8px;
    width: 36px;
    height: 36px;
    display: flex;
    align-items: center;
    justify-content: center;
    background: ${(props) => props.search ? "black" : "#e5e5e5"};
    cursor: ${(props) => props.search ? "pointer" : "auto"};
    border-radius: 25px;
`