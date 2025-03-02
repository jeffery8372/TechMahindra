import { HStack, Switch, useColorMode, Icon } from "@chakra-ui/react";
import { FaSun, FaMoon } from "react-icons/fa";
const DarkSwitch: React.FC = () => {
  const { colorMode, toggleColorMode } = useColorMode();
  return (
    <HStack>
      <Icon as={colorMode === "light" ? FaSun:FaMoon} boxSize={5} />
      <Switch
        colorScheme="gray"
        isChecked={colorMode === "dark"}
        onChange={toggleColorMode}
      />
    </HStack>
  );
};
export default DarkSwitch;