import React, { useContext } from 'react'
import ThemeContext from './ThemeContext'

const MainContent = () => {
    const {theme, toggleTheme} = useContext(ThemeContext)

    return (
        <div
            style={{
                width: "100vw",
                height: "100vh",
                padding: "1.5rem",
                background: theme,
                color: theme == "white" ? "black" : "white",
            }}
        >
            <p>안녕하세요, 테마 변경 테스트중입니다.</p>
            <button onClick={toggleTheme}>테마변경</button>
        </div>
    )
}

export default MainContent