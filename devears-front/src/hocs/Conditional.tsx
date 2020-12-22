import React, {ReactNode} from "react";

interface ConditionalProps {
  children: ReactNode;
  condition: boolean;
}

const Conditional: React.FC<ConditionalProps> = ({ children, condition }) => {
  return <>{ condition && children }</>
};

export default React.memo(Conditional);