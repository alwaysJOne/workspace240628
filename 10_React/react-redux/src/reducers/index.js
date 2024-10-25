import { combineReducers } from 'redux'
import userReducer from './user'
import boardReducer from './board'

export default combineReducers({
    user: userReducer,
    board: boardReducer,
})