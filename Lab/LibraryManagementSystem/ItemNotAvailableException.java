class ItemNotAvailableException extends Exception {
    ItemNotAvailableException(String msg) { super(msg); }
}
class MemberLimitExceededException extends Exception {
    MemberLimitExceededException(String msg) { super(msg); }
}